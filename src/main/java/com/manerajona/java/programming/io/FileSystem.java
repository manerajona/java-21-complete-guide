package com.manerajona.java.programming.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.DirectoryStream.Filter;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.MessageFormat;

import static java.nio.file.FileSystems.getDefault;
import static java.nio.file.Files.copy;
import static java.nio.file.Files.createTempFile;
import static java.nio.file.Files.deleteIfExists;
import static java.nio.file.Files.exists;
import static java.nio.file.Files.getLastModifiedTime;
import static java.nio.file.Files.isRegularFile;
import static java.nio.file.Files.move;
import static java.nio.file.Files.newBufferedReader;
import static java.nio.file.Files.newDirectoryStream;
import static java.nio.file.Files.readAttributes;
import static java.nio.file.Files.size;

public class FileSystem {

    public static void main(String[] args) {
        // Paths
        Path localFilePath = getDefault().getPath("src/com/manerajona/java/programming/io/NewFile.txt");
        printFile(localFilePath);

        Path externalFilePath = getDefault().getPath("../ExternalFile.txt");
        printFile(externalFilePath);

        Path current = Paths.get("");
        System.out.println(current.toAbsolutePath());

        // Check existence
        Path nonExistingPath = getDefault().getPath("/opt/thisFileDoestExists.txt");
        System.out.println(nonExistingPath.toAbsolutePath() + "                              exists=" + exists(nonExistingPath));
        System.out.println(externalFilePath.toAbsolutePath() + "    exists=" + exists(externalFilePath));

        // Copy
        Path sourceFile = getDefault().getPath("Examples", "file1.txt");
        Path copyFile = getDefault().getPath("Examples", "file1copy.txt");
        System.out.println("Copy successful=" + copyFiles(sourceFile, copyFile));

        copyFile = getDefault().getPath("Examples", "Dir1", "file1.txt");
        System.out.println("Copy successful=" + copyFiles(sourceFile, copyFile));

        /*sourceFile = FileSystems.getDefault().getPath("Examples", "Dir1");
        copyFile = FileSystems.getDefault().getPath("Examples", "Dir3");
        System.out.println("Copy successful=" + copyFiles(sourceFile, copyFile));*/

        // Move
        sourceFile = getDefault().getPath("Examples", "Dir1", "file1.txt");
        copyFile = getDefault().getPath("Examples", "Dir3", "file1.txt");
        System.out.println("Copy successful=" + moveFile(sourceFile, copyFile));

        // Delete
        sourceFile = getDefault().getPath("Examples", "file1copy.txt");
        System.out.println("Copy successful=" + deleteFile(sourceFile));

        // Create

        // File properties
        Path filePath = getDefault().getPath("Examples", "Dir1/file2.txt");
        printFileDescription(filePath);

        // File Content
        Filter<Path> filter = p -> isRegularFile(p);
        Path directory = getDefault().getPath("FileTree/Dir2");  // FileTree\\Dir2 (windows)

        try (DirectoryStream<Path> contents = newDirectoryStream(directory, filter)) {
            contents.forEach(f -> System.out.println(f.getFileName()));
        } catch (IOException | DirectoryIteratorException e) {
            System.out.println(e.getMessage());
        }

        // File separators
        String separator = File.separator;
        System.out.println(separator);
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);

        // Temporary Files
        try {
            Path tempFile = createTempFile("myapp", ".appext");
            System.out.println("Temporary file path = " + tempFile.toAbsolutePath());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Print all file system
        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        stores.forEach(store -> {
            System.out.println("Volume name/Drive letter = " + store);
            //System.out.println("file store = " + store.name());
        });

        // Root
        System.out.println("*******************");
        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
        rootPaths.forEach(System.out::println);

        // File visitor
        System.out.println("---Walking Tree for Dir2---");
        Path dir2Path = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
        try {
            Files.walkFileTree(dir2Path, new PrintNames());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("---Copy Dir2 to Dir4/Dir2Copy---");
        Path copyPath = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir4" + File.separator + "Dir2Copy");
        try {
            Files.walkFileTree(dir2Path, new CopyFiles(dir2Path, copyPath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Mapping
        File file = new File("/Examples/file.txt");
        Path convertedPath = file.toPath();
        System.out.println("convertedPath = " + convertedPath);

        File parent = new File("/Examples");
        File resolvedFile = new File(parent, "dir/file.txt");
        System.out.println(resolvedFile.toPath());

        resolvedFile = new File("/Examples", "dir/file.txt");
        System.out.println(resolvedFile.toPath());

        Path parentPath = Paths.get("/Examples");
        Path childRelativePath = Paths.get("dir/file.txt");
        System.out.println(parentPath.resolve(childRelativePath));

        File workingDirectory = new File("").getAbsoluteFile();
        System.out.println("Working directory = " + workingDirectory.getAbsolutePath());

        System.out.println("--- print Dir2 contents using list() ---");
        File dir2File = new File(workingDirectory, "/FileTree/Dir2");
        String[] dir2Contents = dir2File.list();
        for(int i=0; i< dir2Contents.length; i++) {
            System.out.println("i= " + i + ": " + dir2Contents[i]);
        }

        System.out.println("--- print Dir2 contents using listFiles() ---");
        File[] dir2Files = dir2File.listFiles();
        for(int i=0; i< dir2Files.length; i++) {
            System.out.println("i= " + i + ": " + dir2Files[i].getName());
        }

    }

    private static void printFileDescription(Path filePath) {
        long size = 0;
        try {
            size = size(filePath);
            System.out.println("Size = " + size);
            System.out.println("Last modified =  " + getLastModifiedTime(filePath));

            BasicFileAttributes attrs = readAttributes(filePath, BasicFileAttributes.class);
            System.out.println("Size =  " + attrs.size());
            System.out.println("Last modified =  " + attrs.lastModifiedTime());
            System.out.println("Created = " + attrs.creationTime());
            System.out.println("Is directory = " + attrs.isDirectory());
            System.out.println("Is regular file = " + attrs.isRegularFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printFile(Path path) {
        try (BufferedReader fileReader = newBufferedReader(path)) {
            fileReader.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean copyFiles(Path sourceFile, Path copyFile) {
        boolean success = true;
        try {
            copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
            success = false;
        }
        return success;
    }

    public static boolean moveFile(Path sourceFile, Path destinationFile) {
        boolean success = true;
        try {
            move(sourceFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
            success = false;
        }
        return success;
    }

    public static boolean deleteFile(Path sourceFile) {
        boolean success = true;
        try {
            deleteIfExists(sourceFile);
        } catch (IOException e) {
            e.printStackTrace();
            success = false;
        }
        return success;
    }

    public static class PrintNames extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            System.out.println(file.toAbsolutePath());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
            System.out.println(MessageFormat.format("{0}  ({1})", dir.toAbsolutePath(), attrs.fileKey()));
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            System.out.println(MessageFormat.format("Error accessing file: {0} {1}", file.toAbsolutePath(), exc.getMessage()));
            return FileVisitResult.CONTINUE;
        }
    }

    public static class CopyFiles extends SimpleFileVisitor<Path> {

        private Path sourceRoot;
        private Path targetRoot;

        public CopyFiles(Path sourceRoot, Path targetRoot) {
            this.sourceRoot = sourceRoot;
            this.targetRoot = targetRoot;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            System.out.println("Error accessing file: " + file.toAbsolutePath() + " " + exc.getMessage());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

            Path relativizedPath = sourceRoot.relativize(dir);
            System.out.println("RelativizedPath = " + relativizedPath);
            Path copyDir = targetRoot.resolve(relativizedPath);
            System.out.println("Resolved path for copy = " + copyDir);

            try {
                Files.copy(dir, copyDir);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return FileVisitResult.SKIP_SUBTREE;
            }

            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            Path relativizedPath = sourceRoot.relativize(file);
            System.out.println("RelativizedPath = " + relativizedPath);
            Path copyDir = targetRoot.resolve(relativizedPath);
            System.out.println("Resolved path for copy = " + copyDir);

            try {
                Files.copy(file, copyDir);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            return FileVisitResult.CONTINUE;
        }
    }

}
