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
}