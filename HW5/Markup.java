package markup;

import java.util.List;

public class Markup implements  TextObj {
    private List<TextObj> children;
    String markdownBegin = "", markdownEnd = "", htmlBegin = "", htmlEnd = "";

    Markup(List<TextObj> children) {
        this.children = children;
    }

    private void toMarkdownBegin(StringBuilder stringBuilder) {
        stringBuilder.append(markdownBegin);
    }

    private void toMarkdownEnd(StringBuilder stringBuilder) {
        stringBuilder.append(markdownEnd);
    }

    private void toHtmlBegin(StringBuilder stringBuilder) {
        stringBuilder.append(htmlBegin);
    }

    private void toHtmlEnd(StringBuilder stringBuilder) {
        stringBuilder.append(htmlEnd);
    }

    @Override
    public void toMarkdown(StringBuilder stringBuilder) {
        toMarkdownBegin(stringBuilder);

        for (TextObj to : children) {
            to.toMarkdown(stringBuilder);
        }

        toMarkdownEnd(stringBuilder);
    }

    @Override
    public void toHtml(StringBuilder stringBuilder) {
        toHtmlBegin(stringBuilder);

        for (TextObj to : children) {
            to.toHtml(stringBuilder);
        }

        toHtmlEnd(stringBuilder);
    }
}
