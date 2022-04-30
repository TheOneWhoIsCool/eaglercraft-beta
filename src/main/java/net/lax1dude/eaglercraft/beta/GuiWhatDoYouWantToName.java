package net.lax1dude.eaglercraft.beta;

import java.util.function.Consumer;

import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiDisableButton;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.MathHelper;
import net.minecraft.src.StringTranslate;

public class GuiWhatDoYouWantToName extends GuiScreen {

	private final Consumer<String> cont;
	private final String defaultName;
	private final String title;
	private GuiDisableButton nameField;
	
	public GuiWhatDoYouWantToName(String defaultName, Consumer<String> cont) {
		this.defaultName = defaultName;
		this.cont = cont;
		this.title = StringTranslate.getInstance().translateKey("selectWorld.importName");
	}
	
	public void initGui() {
		nameField = new GuiDisableButton(fontRenderer, width / 2 - 100, height / 3, 200, 20, defaultName);
		controlList.add(new GuiButton(0, (width - 200) / 2, height / 3 + 35, StringTranslate.getInstance().translateKey("gui.done")));
	}
	
	public void drawScreen(int i, int j, float f) {
		drawDefaultBackground();
		drawCenteredString(fontRenderer, title, width / 2, height / 4, 0xFFFFFF);
		nameField.func_22067_c();
		super.drawScreen(i, j, f);
	}
	
	public void actionPerformed(GuiButton bnt) {
		if(bnt.id == 0) {
			String s = nameField.func_22071_a();
			if (MathHelper.func_22282_a(s)) {
				s = defaultName;
			}
			cont.accept(s);
		}
	}

	protected void keyTyped(char c, int i) {
		super.keyTyped(c, i);
		nameField.func_22072_a(c, i);
	}
	
	protected void mouseClicked(int i, int j, int k) {
		super.mouseClicked(i, j, k);
		nameField.func_22069_a(i, j, k);
	}
	
}
