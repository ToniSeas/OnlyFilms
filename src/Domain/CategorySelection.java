package Domain;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import Domain.Button.Button;
import Domain.Button.CategoryButton;
import Utility.ResourcesPath;
import javafx.scene.canvas.GraphicsContext;

public class CategorySelection implements Serializable{

	private static final long serialVersionUID = 1L;

	private InputStream imageLoader; //obtiene la ruta de la imagen
	
	private CategoryList categoryList;

	private Button keepWatching;

	private CategoryButton nodeLeft;
	private CategoryButton nodeCenter;
	private CategoryButton nodeRigth;
	
	private Button nextButton;
	private Button beforeButton;	
	private Button recommendedButton;

	public CategorySelection() throws IOException {
				
		SingletonCategorysAccess.getInstance().loadCategoryNodes();
		
		this.categoryList = SingletonCategorysAccess.getInstance().getCategoryList();
	
		this.keepWatching = new Button(ResourcesPath.KEEPWATCHING, (800/2)-79, (600/2)-50);
		
		this.nextButton = new Button(ResourcesPath.NEXTBUTTOM, 740, (600/2)-50);
		this.beforeButton = new Button(ResourcesPath.BEFOREBUTTOM, 10, (600/2)-50);
		this.recommendedButton = new Button(ResourcesPath.RECOMMENDED, (800/2)-79, (600/2)+50);
		
		this.nodeLeft = new CategoryButton(this.categoryList.getFirstCategory(), 92, 288);
		this.nodeCenter = new CategoryButton(this.categoryList.getNext(this.nodeLeft.getNodo()), 303, 113);
		this.nodeRigth = new CategoryButton(this.categoryList.getNext(this.nodeCenter.getNodo()), 511, 288);
				
	} // Fin del constructor
		
	public void paint (GraphicsContext gc) {

		gc.drawImage(this.nodeLeft.getCategory().getShowImage(), this.nodeLeft.getPositionX(), this.nodeLeft.getPositionY());
		gc.drawImage(this.nodeCenter.getCategory().getShowImage(), this.nodeCenter.getPositionX(), this.nodeCenter.getPositionY());
		gc.drawImage(this.nodeRigth.getCategory().getShowImage(), this.nodeRigth.getPositionX(), this.nodeRigth.getPositionY());

		this.keepWatching.paint(gc);
		this.nextButton.paint(gc);
		this.beforeButton.paint(gc);
		this.recommendedButton.paint(gc);
		
	} // Fin de paint
	
	public void getNextAll () {
		
		this.nodeLeft.setNodo(this.categoryList.getNext(this.nodeLeft.getNodo()));
		this.nodeCenter.setNodo(this.categoryList.getNext(this.nodeCenter.getNodo()));
		this.nodeRigth.setNodo(this.categoryList.getNext(this.nodeRigth.getNodo()));
		
	} // Fin de getNextAll
	
	public void getBeforeAll () {
		
		this.nodeRigth.setNodo(this.categoryList.getBefore(this.nodeRigth.getNodo()));
		this.nodeCenter.setNodo(this.categoryList.getBefore(this.nodeCenter.getNodo()));
		this.nodeLeft.setNodo(this.categoryList.getBefore(this.nodeLeft.getNodo()));
		
		
	} // Fin de getBeforeAll

	public InputStream getImageLoader() {
		return imageLoader;
	}

	public void setImageLoader(InputStream imageLoader) {
		this.imageLoader = imageLoader;
	}
	
	public CategoryList getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(CategoryList categoryList) {
		this.categoryList = categoryList;
	}

	public Button getNextButton() {
		return nextButton;
	}

	public void setNextButton(Button nextButton) {
		this.nextButton = nextButton;
	}

	public Button getBeforeButton() {
		return beforeButton;
	}

	public void setBeforeButton(Button beforeButton) {
		this.beforeButton = beforeButton;
	}

	public CategoryButton getNodeLeft() {
		return nodeLeft;
	}

	public void setNodeLeft(CategoryButton nodeLeft) {
		this.nodeLeft = nodeLeft;
	}

	public CategoryButton getNodeCenter() {
		return nodeCenter;
	}

	public void setNodeCenter(CategoryButton nodeCenter) {
		this.nodeCenter = nodeCenter;
	}

	public CategoryButton getNodeRigth() {
		return nodeRigth;
	}

	public void setNodeRigth(CategoryButton nodeRigth) {
		this.nodeRigth = nodeRigth;
	}

	public Button getKeepWatching() {
		return keepWatching;
	}

	public void setKeepWatching(Button keepWatching) {
		this.keepWatching = keepWatching;
	}

	public Button getRecommendedButton() {
		return recommendedButton;
	}

	public void setRecommendedButton(Button recommendedButton) {
		this.recommendedButton = recommendedButton;
	}

} // Fin de clase
