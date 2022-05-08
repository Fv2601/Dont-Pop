package game.ui;

import game.engine.GameApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Scale;

/**
 * MenuScene displays the Main Menu GUI.
 */
public class MenuScene {
	
	private static final double DEFAULT_SIZE = 300;
	private final Scene scene;
	
	/**
	 * Creates & initializes a MenuScene.
	 * @param screenSize
	 * @throws Exception (necessary to load files, esp. FXML)
	 */
	public MenuScene(final GameApplication application, final int screenSize) throws Exception {
		final FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/menuscene.fxml"));
		
		//controller created here
		final MenuSceneController controller = new MenuSceneController(application);
		loader.setController(controller);
		
		//load GUI from FXML
		final AnchorPane root = loader.load();
		
		final double scaleFactor = (double)screenSize / DEFAULT_SIZE;
		final Scale scaleTransformation = new Scale(scaleFactor, scaleFactor, 0, 0);
		root.getTransforms().add(scaleTransformation);
		
		this.scene = new Scene(root, screenSize, screenSize);
		this.scene.getStylesheets().add(getClass().getResource("/css/menuscene-styles.css").toExternalForm());
	}
	
	/**
	 * Gets the Scene inside MenuScene
	 * @return this.scene
	 */
	public Scene getScene() {
		return this.scene;
	}
	
	/**
	 * Gets this object.
	 * @return MenuScene
	 */
	public MenuScene get() {
		return this;
	}
}
