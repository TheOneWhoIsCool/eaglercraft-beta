package net.lax1dude.eaglercraft.beta;

import java.util.Collection;
import java.util.function.Consumer;

import net.lax1dude.eaglercraft.EaglerAdapter;
import net.lax1dude.eaglercraft.adapter.EaglerAdapterImpl2.FileEntry;

public class FilesystemUtils {
	
	public static void recursiveDeleteDirectory(String dir) {
		Collection<FileEntry> lst = EaglerAdapter.listFiles(dir, true, true);
		lst.forEach(new Consumer<FileEntry>() {
			@Override
			public void accept(FileEntry t) {
				if(!t.isDirectory) {
					EaglerAdapter.deleteFile(t.path);
				}
			}
		});
		lst.forEach(new Consumer<FileEntry>() {
			@Override
			public void accept(FileEntry t) {
				if(t.isDirectory) {
					EaglerAdapter.deleteFile(t.path);
				}
			}
		});
		EaglerAdapter.deleteFile(dir);
	}

}
