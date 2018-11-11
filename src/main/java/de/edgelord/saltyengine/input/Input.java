/*
 * This software was published under the MIT License.
 * The full LICENSE file can be found here: https://github.com/edgelord314/salty-enigne/tree/master/LICENSE
 *
 * Copyright (c) since 2018 by the Salty Engine developers,
 * Maintained by Malte Dostal
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package de.edgelord.saltyengine.input;

import de.edgelord.saltyengine.transform.Transform;
import de.edgelord.saltyengine.transform.Vector2f;
import de.edgelord.saltyengine.utils.Directions;

import java.awt.event.KeyEvent;

public class Input {

    public static boolean inputUp = false;
    public static boolean inputDown = false;
    public static boolean inputRight = false;
    public static boolean inputLeft = false;
    public static char lastInputKey;
    /**
     * You have to add a ifn check if you use this!
     */
    public static KeyEvent lastInput = null;
    /**
     * For input that is not meant for typing use this!
     * Please use this for every input that has to do with controls etc etc
     */
    public static Keyboard keyboardInput = new Keyboard();
    public static Vector2f cursorPosition = new Vector2f(0, 0);
    public static Transform cursor = new Transform(0, 0, 0, 0);
    public static boolean mouseDrags = false;
    public static boolean mousePresses = false;

    public static Directions getInput() {

        Directions input = new Directions();

        if (inputUp) {
            input.setDirection(Directions.Direction.UP);
        }

        if (inputDown) {
            input.setDirection(Directions.Direction.DOWN);
        }

        if (inputRight) {
            input.setDirection(Directions.Direction.RIGHT);
        }

        if (inputLeft) {
            input.setDirection(Directions.Direction.LEFT);
        }

        return input;
    }

    public static boolean isInputUp() {
        return inputUp;
    }

    public static boolean isInputDown() {
        return inputDown;
    }

    public static boolean isInputRight() {
        return inputRight;
    }

    public static boolean isInputLeft() {
        return inputLeft;
    }

    public static char getLastInputKey() {
        return lastInputKey;
    }

    public static KeyEvent getLastInput() {
        return lastInput;
    }

    public static Keyboard getKeyboardInput() {
        return keyboardInput;
    }

    public static Vector2f getCursorPosition() {
        return cursorPosition;
    }

    public static Transform getCursor() {
        return cursor;
    }

    public static boolean isMouseDrags() {
        return mouseDrags;
    }

    public static boolean isMousePresses() {
        return mousePresses;
    }
}