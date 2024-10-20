package JavaDiscordBot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.modals.ModalMapping;

public class Listeners extends ListenerAdapter {

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        if (event.getButton().getId().equals("yes-button")){
            event.reply("Nice! We've just registered you in this tournament.").queue();
        } else if (event.getButton().getId().equals("no-button")){
            event.reply("Unfortunate, we hope to see you in the next tournament.").queue();
        }
        event.getMessage().delete().queue();
    }

    @Override
    public void onModalInteraction(ModalInteractionEvent event) {
        if (event.getModalId().equals("person-modal")) {
            ModalMapping nameVar = event.getValue("name-field");
            ModalMapping ageVar = event.getValue("age-field");
            ModalMapping descriptionVar = event.getValue("desc-field");

            String name = nameVar.getAsString();
            String desc = nameVar.getAsString();
            String age;
            if (ageVar.getAsString().isBlank()){
                age = "N/A";
            } else {
                age = ageVar.getAsString();
            }

            EmbedBuilder builder = new EmbedBuilder();
            builder.setTitle("New Person!");
            builder.addField("Name:", name, false);
            builder.addField("Age:", age, false);
            builder.addField("Description:", desc, false);

            builder.setFooter("Welcome to our community!");
            builder.build();

            event.replyEmbeds(builder.build()).queue();
        }
    }
}