/*^
  ===========================================================================
  Diff Detector - FX
  ===========================================================================
  Copyright (C) 2017 Gianluca Costa
  ===========================================================================
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
  ===========================================================================
*/

package info.gianlucacosta.diffdetector.fx.main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;

public class MainScene extends Scene {
    public static MainScene create() {
        URL sceneUrl =
                MainScene.class.getResource("MainScene.fxml");

        FXMLLoader fxmlLoader =
                new FXMLLoader(sceneUrl);

        fxmlLoader.setController(new MainController());

        try {
            MainScene scene =
                    new MainScene(fxmlLoader.load());

            scene.getStylesheets().addAll(
                    MainScene.class.getResource("MainScene.css").toExternalForm()
            );

            return scene;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private MainScene(Parent root) {
        super(root);
    }
}
