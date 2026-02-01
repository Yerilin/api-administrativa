package ar.utn.ba.ddsi.apiadmi.rateLimiting;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class RateLimitFilter extends OncePerRequestFilter {

    private static final int MAX_REQUESTS = 15;
    private static final long WINDOW_MS = 60_000;

    private final Map<String, Counter> requests = new ConcurrentHashMap<>();

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        // solo limitar operaciones que modifican estado
        return !(
                request.getRequestURI().startsWith("/hechos") &&
                        ("PUT".equals(request.getMethod())
                                || "POST".equals(request.getMethod())
                                || "DELETE".equals(request.getMethod()))
        );
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String ip = request.getRemoteAddr();
        long now = Instant.now().toEpochMilli();

        Counter counter = requests.computeIfAbsent(ip, k -> new Counter(now));

        synchronized (counter) {
            if (now - counter.windowStart > WINDOW_MS) {
                counter.windowStart = now;
                counter.count = 0;
            }

            counter.count++;

            if (counter.count > MAX_REQUESTS) {
                response.setStatus(429);
                response.getWriter().write("Rate limit exceeded");
                return;
            }
        }

        filterChain.doFilter(request, response);
    }

    private static class Counter {
        long windowStart;
        int count;

        Counter(long windowStart) {
            this.windowStart = windowStart;
            this.count = 0;
        }
    }
}