package JavaDiscordBot;

import JavaDiscordBot.Commands.Embed;
import JavaDiscordBot.Commands.ModalText;
import JavaDiscordBot.Commands.Sum;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main (String[] args) throws LoginException {
        Dotenv dotenv = Dotenv.load();

        String token = dotenv.get("DISCORD_BOT_TOKEN");

        JDA jda = JDABuilder.createDefault(token)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();
        jda.addEventListener(new Listeners());

        CommandManager manager = new CommandManager();
        manager.add(new Sum());
        manager.add(new Embed());
        manager.add(new ModalText());

        jda.addEventListener(manager);
    }
}