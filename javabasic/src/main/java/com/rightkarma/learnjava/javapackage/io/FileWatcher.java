package com.rightkarma.learnjava.javapackage.io;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

public class FileWatcher {

	public void watchFile() {
		try (WatchService service = FileSystems.getDefault().newWatchService()) {
			// get the path to watch
			Path path = Paths.get("files");
			// create watch key and register the events to watch
			WatchKey watchKey = path.register(service, 
					StandardWatchEventKinds.ENTRY_CREATE, 
					StandardWatchEventKinds.ENTRY_DELETE,
					StandardWatchEventKinds.ENTRY_MODIFY);
			// use watchkey to poll events
			do {
				List<WatchEvent<?>> eventList = watchKey.pollEvents();
				for ( WatchEvent<?> event : eventList) {
					WatchEvent.Kind<?> kind=event.kind();
					Path eventPath = (Path) event.context();
					System.out.println(path +":"+kind+":"+eventPath);
				}
			} while (watchKey.reset()); 
				
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
		new FileWatcher().watchFile();
	}
}
/*OUTPUT
files:ENTRY_DELETE:tt.txt
files:ENTRY_CREATE:tt
files:ENTRY_MODIFY:tt
files:ENTRY_MODIFY:tt
files:ENTRY_MODIFY:tt
files:ENTRY_DELETE:tt
*/