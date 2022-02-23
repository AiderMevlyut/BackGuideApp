package demo.model;

public class Words {
    private int id;
    private String name;
    private String transcription;
    private String image;
    private String translate;
    private String category;
    private String language;
    private String translateTo;

    public Words(){

    }

    public Words(int id, String name, String transcription, String image, String translate, String category, String language, String translateTo){
        this.id = id;
        this.name = name;
        this.transcription = transcription;
        this.image = image;
        this.translate = translate;
        this.category = category;
        this.language = language;
        this.translateTo = translateTo;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTranscription() {
        return transcription;
    }

    public String getImage() {
        return image;
    }

    public String getTranslate() {
        return translate;
    }

    public String getCategory() {
        return category;
    }

    public String getLanguage() {
        return language;
    }

    public String getTranslateTo() {
        return translateTo;
    }

    @Override
    public String toString() {
        return "Words{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", transcription='" + transcription + '\'' +
                ", image='" + image + '\'' +
                ", translate='" + translate + '\'' +
                ", category='" + category + '\'' +
                ", language='" + language + '\'' +
                ", translateTo='" + translateTo + '\'' +
                '}';
    }
}