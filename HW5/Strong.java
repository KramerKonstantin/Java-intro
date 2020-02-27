package markup;

import java.util.List;

class Strong extends Markup {
    Strong(List<TextObj> children) {
        super(children);

        markdownBegin = "__";
        markdownEnd = "__";
        htmlBegin = "<strong>";
        htmlEnd = "</strong>";
    }
}
