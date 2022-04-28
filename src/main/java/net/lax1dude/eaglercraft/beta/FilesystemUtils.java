package net.lax1dude.eaglercraft.beta;

import java.util.function.Consumer;

import net.lax1dude.eaglercraft.EaglerAdapter;
import net.lax1dude.eaglercraft.adapter.EaglerAdapterImpl2.FileEntry;

public class FilesystemUtils {
	
	public static void recursiveDeleteDirectory(String dir) {
		EaglerAdapter.listFiles(dir, true, true).forEach(new Consumer<FileEntry>() {
			@Override
			public void accept(FileEntry t) {
				EaglerAdapter.deleteFile(t.path);
			}
		});
		EaglerAdapter.deleteFile(dir);
	}

}
