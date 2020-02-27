package markup;

import java.util.List;

class Strikeout extends Markup {
    Strikeout(List<TextObj> children) {
        super(children);

        markdownBegin = "~";
        markdownEnd = "~";
        htmlBegin = "<s>";
        htmlEnd = "</s>";
    }
}
