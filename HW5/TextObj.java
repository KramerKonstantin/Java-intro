package markup;

public interface TextObj {
    void toMarkdown(StringBuilder stringBuilder);

    void toHtml(StringBuilder stringBuilder);
}
