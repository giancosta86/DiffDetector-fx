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

import info.gianlucacosta.diffdetector.core.ComparisonResult;
import info.gianlucacosta.diffdetector.fx.util.Alerts;
import info.gianlucacosta.diffdetector.fx.util.DiffTextArea;
import info.gianlucacosta.diffdetector.sdk.SimpleDiffServiceClient;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


class MainController implements Initializable {
    @FXML
    TextField serverField;

    @FXML
    ScrollPane leftPane;

    DiffTextArea leftArea =
            new DiffTextArea();


    @FXML
    ScrollPane rightPane;


    DiffTextArea rightArea =
            new DiffTextArea();


    @FXML
    Button compareButton;

    @FXML
    ProgressIndicator progressIndicator;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        serverField.setText("http://localhost:8080");

        leftPane.setContent(leftArea);

        leftArea.editableProperty().bind(
                compareButton.disabledProperty().not()
        );

        leftArea.replaceText("ABCDEFGHIJKLMNOPQRSTUVW");

        leftArea.setOnKeyTyped(this::resetDiffStyling);

        rightPane.setContent(rightArea);

        rightArea.editableProperty().bind(
                leftArea.editableProperty()
        );

        rightArea.replaceText("ABCDXXXHIJXLMXXXXXSTUXX");

        rightArea.setOnKeyTyped(this::resetDiffStyling);

        progressIndicator.visibleProperty().bind(
                compareButton.disabledProperty()
        );
    }

    private void resetDiffStyling(KeyEvent event) {
        leftArea.clearDiffs();
        rightArea.clearDiffs();
    }

    @FXML
    void compare() {
        CompareTask compareTask =
                new CompareTask(
                        serverField.getText()
                );

        compareButton.setDisable(true);
        new Thread(compareTask).start();
    }


    private class CompareTask extends Task<Optional<ComparisonResult>> {
        private final String endpoint;

        public CompareTask(String endpoint) {
            this.endpoint = endpoint;
        }

        @Override
        protected Optional<ComparisonResult> call() throws Exception {
            SimpleDiffServiceClient diffServiceClient =
                    new SimpleDiffServiceClient(endpoint);


            return
                    diffServiceClient.compare(
                            leftArea.getText().getBytes(),
                            rightArea.getText().getBytes()
                    );
        }

        @Override
        protected void succeeded() {
            Optional<ComparisonResult> comparisonResultOption =
                    getValue();

            if (comparisonResultOption.isPresent()) {
                ComparisonResult comparisonResult =
                        comparisonResultOption.get();

                if (comparisonResult.isSameLength()) {
                    if (comparisonResult.getDiffs().isEmpty()) {
                        Alerts.showInfoBox("The 2 strings are equal!");
                    } else {
                        comparisonResult.getDiffs().forEach(diff -> {
                            leftArea.highlightDiff(diff);
                            rightArea.highlightDiff(diff);
                        });
                    }
                } else {
                    Alerts.showWarningBox("The 2 strings have different lengths!\nDiffs were not computed.");
                }
            } else {
                Alerts.showErrorBox("It was impossible to retrieve the result from the server.");
            }


            compareButton.setDisable(false);
        }

        @Override
        protected void failed() {
            compareButton.setDisable(false);
        }
    }
}
