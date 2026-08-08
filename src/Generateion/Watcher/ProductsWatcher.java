package Generateion.Watcher;

import java.io.IOException;
import java.nio.file.*;

public class ProductsWatcher {

    private final Path watchDir;
    private final String targetFileName;
    private final Runnable onChangeCallback;

    public ProductsWatcher(String filePath, Runnable onChangeCallback) {
        Path fullPath = Paths.get(filePath);
        this.watchDir = fullPath.getParent() != null ? fullPath.getParent() : Paths.get(".");
        this.targetFileName = fullPath.getFileName().toString();
        this.onChangeCallback = onChangeCallback;
    }

    public void startWatching() {
        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            watchDir.register(watchService,
                    StandardWatchEventKinds.ENTRY_MODIFY,
                    StandardWatchEventKinds.ENTRY_CREATE);

            System.out.println("[Watcher] مراقبة الملف: " + targetFileName + " ...");

            while (true) {
                WatchKey key = watchService.take();

                for (WatchEvent<?> event : key.pollEvents()) {
                    Path changed = (Path) event.context();

                    if (changed.getFileName().toString().equals(targetFileName)) {
                        System.out.println("[Watcher] تغيير مكتشف بـ " + targetFileName + " → إعادة التوليد...");
                        onChangeCallback.run();
                    }
                }

                boolean valid = key.reset();
                if (!valid) break;
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("[Watcher] خطأ: " + e.getMessage());
        }
    }
}