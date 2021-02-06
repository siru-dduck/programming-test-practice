package dfsbfs;

import java.util.*;

class HTMLDocument {
    private HTMLElement root;

    public void setRoot(HTMLElement root) {
        this.root = root;
    }

    public void bfs() {
        Queue<HTMLElement> queue = new LinkedList<>();
        Set<HTMLElement> set = new HashSet<>();
        queue.add(root);
        set.add(root);
        while (!queue.isEmpty()) {
            HTMLElement currentElement = queue.poll();
            currentElement.getChildren().forEach(node -> {
                if (!set.contains(node)) {
                    queue.add(node);
                    set.add(node);
                }
            });
            currentElement.showTag();
        }
        ;
    }

    public void dfs() {
        Stack<HTMLElement> stack = new Stack<>();
        Set<HTMLElement> set = new HashSet<>();
        stack.push(root);
        set.add(root);
        while (!stack.isEmpty()) {
            HTMLElement currentElement = stack.pop();
            currentElement.getChildren().forEach(node -> {
                if (!set.contains(node)) {
                    stack.push(node);
                    set.add(node);
                }
            });
            currentElement.showTag();
        }
        ;
    }
}

class HTMLElement {
    private String tagName;
    private final List<HTMLElement> children;

    public HTMLElement(String tagName) {
        this.tagName = tagName;
        children = new ArrayList<>();
    }

    public void showTag() {
        System.out.println(tagName + "태그");
    }

    public void appendChild(HTMLElement element) {
        children.add(element);
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public List<HTMLElement> getChildren() {
        return children;
    }

}

public class DOM {

    public static void main(String[] args) {
        HTMLDocument document = new HTMLDocument();
        HTMLElement html = new HTMLElement("html");
        HTMLElement head = new HTMLElement("head");
        HTMLElement body = new HTMLElement("body");
        HTMLElement meta1 = new HTMLElement("meta");
        HTMLElement meta2 = new HTMLElement("meta");
        HTMLElement title = new HTMLElement("title");
        HTMLElement h1 = new HTMLElement("h1");
        HTMLElement ul = new HTMLElement("ul");
        HTMLElement li1 = new HTMLElement("li");
        HTMLElement li2 = new HTMLElement("li");
        HTMLElement li3 = new HTMLElement("li");

        html.appendChild(head);
        html.appendChild(body);
        head.appendChild(meta1);
        head.appendChild(meta2);
        head.appendChild(title);
        body.appendChild(h1);
        body.appendChild(ul);
        ul.appendChild(li1);
        ul.appendChild(li2);
        ul.appendChild(li3);

        document.setRoot(html);
        System.out.println("==== bfs ====");
        document.bfs();

        System.out.println("==== dfs ====");
        document.dfs();

    }

}
