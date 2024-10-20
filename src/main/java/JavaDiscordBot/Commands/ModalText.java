package JavaDiscordBot.Commands;

import JavaDiscordBot.ICommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;


import java.util.List;

public class ModalText implements ICommand {

    @Override
    public String getName() {
        return "modalform";
    }

    @Override
    public String getDescription() {
        return "creates a form";
    }

    @Override
    public List<OptionData> getOptions() {
        return null;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        TextInput name = TextInput.create("name-field", "name", TextInputStyle.SHORT)
                .setRequired(true)
                .setMinLength(1)
                .setMaxLength(100)
                .build();

        TextInput age = TextInput.create("age-field", "age", TextInputStyle.SHORT)
                .setRequired(false)
                .build();

        TextInput description = TextInput.create("desc-field", "desc", TextInputStyle.SHORT)
                .setRequired(true)
                .setPlaceholder("Describe yourself...")
                .build();

        Modal modal = Modal.create("person-modal", "form")
                .addActionRows(ActionRow.of(name), ActionRow.of(age), ActionRow.of(description))
                .build();

        event.replyModal(modal).queue();
    }
}
