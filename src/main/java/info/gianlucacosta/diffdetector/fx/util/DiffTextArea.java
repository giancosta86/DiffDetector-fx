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

import info.gianlucacosta.diffdetector.core.Diff;
import org.fxmisc.richtext.StyleClassedTextArea;

/**
 * Text area dedicated to highlighting diffs.
 * Its styles are:
 * <ul>
 * <li><b>diff-text-area</b>: applied to the whole component</li>
 * <li><b>defaultText</b>: applied to default text</li>
 * <li><b>diffText</b>: applied to text sections that do not match</li>
 * </ul>
 */
public class DiffTextArea extends StyleClassedTextArea {
    public DiffTextArea() {
        setWrapText(true);
        getStyleClass().add("diff-text-area");
    }


    public void clearDiffs() {
        setStyleClass(0, getLength(), "defaultText");
    }


    public void highlightDiff(Diff diff) {
        setStyleClass(
                diff.getOffset(),
                diff.getOffset() + diff.getLength(),
                "diffText");
    }
}
