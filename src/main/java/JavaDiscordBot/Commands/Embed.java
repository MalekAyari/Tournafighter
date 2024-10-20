package JavaDiscordBot.Commands;

import JavaDiscordBot.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.awt.*;
import java.util.List;

public class Embed implements ICommand {
    @Override
    public String getName() {
        return "embed";
    }

    @Override
    public String getDescription() {
        return "sends an embed";
    }

    @Override
    public List<OptionData> getOptions() {
        return null;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        EmbedBuilder builder = new EmbedBuilder();
        builder.setTitle("New Tournament!");
        builder.setDescription("Tekken Weekly Tournament 3");

        builder.setAuthor(event.getUser().getEffectiveName(), event.getUser().getEffectiveAvatarUrl());

        builder.addField("Date", "11/2/2024", true);
        builder.addField("Time", "18:00", true);

        event.reply("")
                .setEmbeds(builder.build())
                .addActionRow(
                        Button.success("yes-button", "Yes"),
                        Button.danger("no-button", "No")
                ).queue();
    }
}
