package edu.tec.ic6821.fulltextsearch.tokenizer;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.Optional;

public final class DefaultFileTokenizerFactory implements FileTokenizerFactory {

    private static final String FILE_EXT_PDF = "pdf";
    private static final String FILE_EXT_TXT = "txt";

    @Override
    public Optional<FileTokenizer> fileTokenizer(File file) {
        final String extension = FilenameUtils.getExtension(file.getName());
        if (FILE_EXT_PDF.equalsIgnoreCase(extension)) {
            return Optional.of(new PdfFileTokenizer(file));
        } else if (FILE_EXT_TXT.equalsIgnoreCase(extension)) {
            return Optional.of(new TxtFileTokenizer(file));
        } else {
            return Optional.empty();
        }
    }
}
