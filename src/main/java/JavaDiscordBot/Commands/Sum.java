package JavaDiscordBot.Commands;

import JavaDiscordBot.ICommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.ArrayList;
import java.util.List;

public class Sum implements ICommand {

    @Override
    public String getName() {
        return "sum";
    }

    @Override
    public String getDescription() {
        return "sums two numbers";
    }

    @Override
    public List<OptionData> getOptions() {
        List<OptionData> data = new ArrayList<>();
        data.add(new OptionData(OptionType.INTEGER, "n1", "first number", true));
        data.add(new OptionData(OptionType.INTEGER, "n2", "second number", true));
        return data;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("sum"))
            event.reply("Incorrect Slash Command Test").queue();

        OptionMapping n1 = event.getOption("n1");
        OptionMapping n2 = event.getOption("n2");
        int num1 = n1.getAsInt();
        int num2 = n2.getAsInt();
        int num3 = num1+num2;
        event.reply(num1 + " + " + num2 + " = " + num3).queue();
    }
}
