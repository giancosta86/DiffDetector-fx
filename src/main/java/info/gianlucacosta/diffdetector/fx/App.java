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

package info.gianlucacosta.diffdetector.fx;

import info.gianlucacosta.diffdetector.diffdetector_fx.ArtifactInfo;
import info.gianlucacosta.diffdetector.fx.main.MainScene;
import info.gianlucacosta.diffdetector.icons.MainIcon;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        MainScene mainScene =
                MainScene.create();

        primaryStage.getIcons().add(
                new Image(MainIcon.get(32)
                )
        );

        primaryStage.setTitle(ArtifactInfo.getName());

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
