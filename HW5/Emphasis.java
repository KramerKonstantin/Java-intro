package markup;

import java.util.List;

class Emphasis extends Markup {
    Emphasis(List<TextObj> children) {
        super(children);

        markdownBegin = "*";
        markdownEnd = "*";
        htmlBegin = "<em>";
        htmlEnd = "</em>";
    }
}
