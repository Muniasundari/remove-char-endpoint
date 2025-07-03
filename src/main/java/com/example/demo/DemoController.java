package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/remove")
public class DemoController {

    @GetMapping
    public ResponseEntity<String> removeFirstAndLast(@RequestParam String input) {
        if (input == null || input.length() < 2) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Input must have at least 2 characters");
        } else if (input.length() == 2) {
            return ResponseEntity.ok("");
        } else {
            return ResponseEntity.ok(StringConverter(input));
        }
    }
    
    public String StringConverter (String input) {
      
        if (input.length() > 0) {
            input = input.substring(0, input.length() - 1);
        }

        int index = 0;
        while (index < input.length() && Character.isDigit(input.charAt(index))) {
            index++;
        }

        String output;
        if (index > 0) {
            output = input.substring(0, index) + "_" + input.substring(index);
        } else {
            output = (input.length() > 0) ? input.substring(1) : "";
        }

            return output;
        
    }
}