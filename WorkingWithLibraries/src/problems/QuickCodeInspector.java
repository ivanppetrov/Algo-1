package problems;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.apache.commons.io.FileUtils;

import syntaxhighlight.SyntaxHighlighter;
import syntaxhighlighter.SyntaxHighlighterParser;
import syntaxhighlighter.brush.BrushCss;
import syntaxhighlighter.brush.BrushJScript;
import syntaxhighlighter.brush.BrushJava;
import syntaxhighlighter.brush.BrushPhp;
import syntaxhighlighter.theme.ThemeDjango;

import com.nitido.utils.toaster.Example;

public class QuickCodeInspector {
	 static List<File> fileslist;
	
	public static void getFile(File filePath) {		
		fileslist = (List<File>) FileUtils.listFiles(filePath, null, true);
	}
	
	public static File getNextFile(File file) {
		int listSize = fileslist.size();
		File nextFile = null;
		for (int i = 0; i < listSize; i++) {
			if (fileslist.get(i).getName().equals(file.getName())) {
				if (i != listSize - 1) {
					nextFile = fileslist.get(i + 1);
					break;
				} else {
					nextFile = fileslist.get(0);
					break;
				}
			}
		}
		
		return nextFile;
	}
	
	public static File getPrevFile(File file) {
		int listSize = fileslist.size();
		File nextFile = null;
		for (int i = 0; i < listSize; i++) {
			if (fileslist.get(i).getName().equals(file.getName())) {
				if (i != 0) {
					nextFile = fileslist.get(i - 1);
					break;
				} else {
					nextFile = fileslist.get(listSize - 1);
					break;
				}
			}
		}
		
		return nextFile;
	}
	
	public static void main(String[] args) {
		final File file = new File(args[0]);
		String absolutePath = file.getAbsolutePath();
        final String path = absolutePath.substring(0, absolutePath.lastIndexOf(File.separator));
        
		getFile(new File(path));
		
		SwingUtilities.invokeLater(new Runnable() {

		      @Override
		      public void run() {
		        // the SyntaxHighlighter parser
		        SyntaxHighlighterParser parser = new SyntaxHighlighterParser(new BrushJava());
		        // turn HTML script on
		        parser.setHtmlScript(true);
		        // set HTML Script brushes
		        parser.setHTMLScriptBrushes(Arrays.asList(new BrushCss(), new BrushJScript(), new BrushPhp(), new BrushJava()));

		        // initialize the highlighter and use RDark theme
		        final SyntaxHighlighter highlighter = new SyntaxHighlighter(parser, new ThemeDjango());
		        // set the line number count from 10 instead of 1
		        highlighter.setFirstLine(10);
		        // set to highlight line 13, 27, 28, 38, 42, 43 and 53
		        highlighter.setHighlightedLineList(Arrays.asList(13, 27, 28, 38, 42, 43, 53));
		        try {
		          highlighter.setContent(file);
		        } catch (IOException ex) {
		          Logger.getLogger(Example.class.getName()).log(Level.SEVERE, null, ex);
		        }

		        final JFrame frame = new JFrame();
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setTitle(file.getName());
		        frame.setContentPane(highlighter);
		        frame.setLocationByPlatform(true);
		        frame.pack();
		        frame.setVisible(true);
		        frame.setFocusable(true);
		        
		        
		        
		        frame.addKeyListener(new KeyListener() {
		        	File newFile = file;
					@Override
					public void keyPressed(KeyEvent e) {
						//right arrow pressed
						if (e.getKeyCode() == 39) {
							newFile = getNextFile(newFile);
							frame.dispose();
							frame.setTitle(newFile.getName());
							frame.setVisible(true);
						}
						
						//left arrow pressed
						if (e.getKeyCode() == 37) {
							newFile = getPrevFile(newFile);
							frame.dispose();
							frame.setTitle(newFile.getName());
							frame.setVisible(true);
						}
						
					}

					@Override
					public void keyTyped(KeyEvent e) {
					}

					@Override
					public void keyReleased(KeyEvent e) {
					}
				});
		      }
		    });
	}

}
