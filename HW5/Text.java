package markup;

public class Text implements TextObj {
    private String string;

    Text(String string) {
        this.string = string;
    }

    @Override
    public void toMarkdown(StringBuilder stringBuilder) {
        stringBuilder.append(string);
    }

    @Override
    public void toHtml(StringBuilder stringBuilder) {
        stringBuilder.append(string);
    }
}
