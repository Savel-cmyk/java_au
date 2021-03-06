package generator;

import java.util.List;

class Generator {
    public static String generateContent(List<String> oldContent, List<String> newContent, Application.FileType fileType, String fileName) {
        SolutionFile old = SolutionFile.parseFile(oldContent, fileType, fileName);
        old.add(MarkdownEntity.parseEntity(newContent));
        return old.toString();
    }
}
public class Application {

    enum FileType {
        MARKDOWN("<!---->"),
        HTML("<!---->"),
        LATEX("%----");

        private final String fcomment;

        FileType(String comment) {
            fcomment = comment;
        }

        public String FCOMMENT() {
            return fcomment;
        }

    }


    public static void main(String[] args) {
        String userSource = "C:\\Users\\serez\\Projects\\java_au\\src\\generator\\input.txt";
        String source = "C:\\Users\\serez\\Projects\\java_au\\src\\generator\\linked-list.md";
        List<String> newContent = IOUtil.readData(userSource);
        List<String> oldContent = IOUtil.readData(source);

        IOUtil.writeData(source, Generator.generateContent(oldContent, newContent, FileType.MARKDOWN, "linked-list"));
    }
}
