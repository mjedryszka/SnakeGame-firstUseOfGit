package Game.Snake.Engine.Game;


/**
 * Created by Home on 2021-05-30.
 */
public class Controller {
    private Engine engine;
    private View view;

    public Controller(Engine engine, View view) {
        this.engine = engine;
        this.view = view;

        engine.createBoxInEngine();
        view.setupBoxes(engine.getBoxesList());


    }

}
