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

package info.gianlucacosta.diffdetector.fx.util;

import javafx.scene.control.Alert;

public class Alerts {
    private Alerts() {
    }

    public static void showInfoBox(String message) {
        showBox(message, Alert.AlertType.INFORMATION);
    }

    public static void showWarningBox(String message) {
        showBox(message, Alert.AlertType.WARNING);
    }

    public static void showErrorBox(String message) {
        showBox(message, Alert.AlertType.ERROR);
    }

    private static void showBox(String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
