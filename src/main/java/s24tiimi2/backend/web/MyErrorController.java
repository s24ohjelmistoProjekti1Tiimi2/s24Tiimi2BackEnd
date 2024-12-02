package s24tiimi2.backend.web;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyErrorController implements ErrorController {

    @GetMapping("/error")
    public String handleError(HttpServletRequest request) {

    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

    if (status != null) {
    Integer statusCode = Integer.valueOf(status.toString());

    if (statusCode == HttpStatus.NOT_FOUND.value()) {
    return "error/404";
    }
    else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
    return "error/500";
    }
    }

    return "error/error";
    }

    // private static final String PATH = "/error";

    // @GetMapping(PATH)
    // public String handleError() {
    //     return "error";
    // }

}
