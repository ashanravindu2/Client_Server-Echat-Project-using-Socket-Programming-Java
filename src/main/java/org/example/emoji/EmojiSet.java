package org.example.emoji;

import com.vdurmont.emoji.EmojiParser;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class EmojiSet extends VBox {

    private ListView<String> emojiListView;
    public EmojiSet() {
        List<String> emojis = new ArrayList<>();

        String[] emojiHtmlList = new String[]{"&#x1F339;", "&#x1F33A;", "&#x1F33B;", "&#x1F408;", "&#x1F40D;", "&#x1F422;", "&#x1F427;", "&#x1F42E;",
                "&#x1F431;", "&#x1F433;", "&#x1F436;", "&#128514;","&#10084;","&#128525;","&#129315;","&#128522;",
                "&#128591;","&#128149;","&#128557;","&#128293;","&#x1F437;", "&#x1F438;", "&#x1F43C;", "&#x1F43D;", "&#x1F981;", "&#x1F98A;", "&#x1F98D;",
                "&#x1F98E;", "&#x1F98F;", "&#x1F990;", "&#x1F991;","&#128532;","&#128580;","&#128540;","&#9829;","&#9851;","&#128530;",
                "&#128553;","&#9786;","&#128513;","&#128076;","&#128079;","&#128148;","&#128150;","&#128153;",
                "&#128546;","&#128170;","&#129303;","&#128156;","&#128526;","&#128519;","&#127801;","&#129318;",
                "&#127881;","&#128158;","&#9996;","&#10024;","&#129335;","&#128561;","&#128524;","&#127800;",
                "&#128588;","&#128523;","&#127770;","&#127773;","&#128584;","&#128585;","&#128586;"};

        for (String em:emojiHtmlList) {
            emojis.add(EmojiParser.parseToUnicode(em));
        }

        // Create the emoji list view
        emojiListView = new ListView<>();
        emojiListView.setItems(FXCollections.observableArrayList(emojis));

        // Customize the appearance of the list view

        // Create the emoji picker hBox
        HBox hBox = new HBox(emojiListView);
        hBox.setPadding(new Insets(10));

        // Set the picker hBox to the EmojiPicker
        getChildren().add(hBox);
    }

    public ListView<String> getEmojiListView() {
        return emojiListView;
    }

}
