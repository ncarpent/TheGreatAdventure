package game.filereader;

import java.util.Objects;

public record Result(Token token, String content) {
	
    public Result {
      Objects.requireNonNull(token);
      Objects.requireNonNull(content);
    }
    
} 