package academy.learnprogramming;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {

    // == constants ==
    private static final String MAIN_MESSAGE = "game.main.message";
    private static final String RESULT_GAME_WON="game.result.gamewon";
    private static final String RESULT_GAME_LOST="game.result.gamelost";
    private static final String RESULT_INVALID_NUMBER="game.result.invalidNumber";
    private static final String RESULT_FIRST_GUESS="game.result.firstguess";
    private static final String RESULT_LOWER="game.result.lower";
    private static final String RESULT_HIGHER="game.result.higher";
    private static final String RESULT_REMAINING_GUESSES="game.result.remainingGuesses";

    // == fields ==
    private final Game game;
    private final MessageSource messageSource;

    // == constructor ==
    @Autowired
    public MessageGeneratorImpl(Game game, MessageSource messageSource) {
        this.game = game;
        this.messageSource = messageSource;
    }

    // == init ==
    @PostConstruct
    public void init() {
        log.info("game = {}", game);
    }
    // == public methods ==
    @Override
    public String getMainMessage() {
        return getMessage(MAIN_MESSAGE, game.getSmallest(),game.getBiggest());
    }

    @Override
    public String getResultMessage() {

        if(game.isGameWon()) {
            return getMessage(RESULT_GAME_WON, game.getNumber());
        } else if(game.isGameLost()) {
            return getMessage(RESULT_GAME_LOST, game.getNumber());
        } else if(!game.isValidNumberRange()) {
            return getMessage(RESULT_INVALID_NUMBER);
        } else if(game.getRemainingGuesses() == game.getGuessCount()) {
            return getMessage(RESULT_FIRST_GUESS);
        } else {
            String direction = getMessage(RESULT_LOWER);

            if(game.getGuess() < game.getNumber()) {
                direction = getMessage(RESULT_HIGHER);
            }
            return direction + getMessage(RESULT_REMAINING_GUESSES, game.getRemainingGuesses());
        }
    }

    // == private methods ==
    private String getMessage(String code, Object... args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
