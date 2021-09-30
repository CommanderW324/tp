package seedu.address.logic.parser;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.RemarkCommand;
import seedu.address.logic.parser.exceptions.ParseException;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.*;

public class RemarkCommandParser implements Parser<RemarkCommand> {

    public RemarkCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_REMARK);
        Index index;

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE), pe);
        }
        String input = argMultimap.getValue(PREFIX_REMARK).orElse("");
        return new RemarkCommand(index, input);

    }
}
