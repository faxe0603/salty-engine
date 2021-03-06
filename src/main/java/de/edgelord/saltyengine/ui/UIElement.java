/*
 * Copyright 2018 Malte Dostal
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.edgelord.saltyengine.ui;

import de.edgelord.saltyengine.core.Component;
import de.edgelord.saltyengine.core.graphics.SaltyGraphics;
import de.edgelord.saltyengine.core.interfaces.Drawable;
import de.edgelord.saltyengine.core.interfaces.FixedTickRoutine;
import de.edgelord.saltyengine.core.interfaces.KeyboardInputHandler;
import de.edgelord.saltyengine.core.interfaces.MouseInputHandler;
import de.edgelord.saltyengine.core.stereotypes.ComponentContainer;
import de.edgelord.saltyengine.transform.Coordinates;
import de.edgelord.saltyengine.transform.Dimensions;
import de.edgelord.saltyengine.transform.Transform;
import de.edgelord.saltyengine.transform.Vector2f;
import de.edgelord.saltyengine.utils.SaltySystem;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class UIElement extends ComponentContainer implements Drawable, FixedTickRoutine, MouseInputHandler, KeyboardInputHandler {

    private Font font = SaltySystem.defaultFont;

    private Color backgroundColor = Color.DARK_GRAY;
    private Color foregroundColor = Color.WHITE;

    private Transform transform;

    private boolean mouseHoversOver = false;

    private List<Component> components = new CopyOnWriteArrayList<>();

    private boolean suppressClipping = false;

    public static final String BUTTON = "de.edgelord.saltyengine.uiElements.button";
    public static final String LABEL = "de.edgelord.saltyengine.uiElements.label";
    public static final String TEXT_BOX = "de.edgelord.saltyengine.uiElements.textBox";
    public static final String CONTAINER = "de.edgelord.saltyengine.uiElements.container";

    public UIElement(Vector2f position, float width, float height, String tag) {
        super(tag);

        this.transform = new Transform(position, new Dimensions(width, height));
    }

    public UIElement(Transform transform, String tag) {
        this(transform.getPosition(), transform.getWidth(), transform.getHeight(), tag);
    }

    @Override
    public void onFixedTick() {
    }

    @Override
    public abstract void draw(SaltyGraphics saltyGraphics);

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseExitedScreen(MouseEvent e) {
    }

    public void mouseExited(Transform cursor) {
    }

    @Override
    public void mouseEnteredScreen(MouseEvent e) {
    }

    public void mouseEntered(Transform cursor) {
    }

    @Override
    public void mouseWheelMoved(MouseEvent e) {
    }

    public void mouseHover(Transform cursor) {
    }

    @Override
    public void addComponent(Component component) {
        components.add(component);
    }

    @Override
    public void removeComponent(String identifier) {
        components.removeIf(component -> component.getName().equals(identifier));
    }

    @Override
    public void removeComponent(Component component) {
        components.remove(component);
    }

    @Override
    public List<Component> getComponents() {
        return components;
    }

    @Override
    public Component getComponent(String identifier) {

        for (Component component : components) {
            if (component.getName().equals(identifier)) {
                return component;
            }
        }

        return null;
    }

    public void prepareGraphics(SaltyGraphics graphics) {
        graphics.setColor(getBackgroundColor());
        graphics.setFont(getFont());
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Coordinates getCoordinates() {
        return getPosition().convertToCoordinates();
    }

    public boolean isSuppressClipping() {
        return suppressClipping;
    }

    public void setSuppressClipping(boolean suppressClipping) {
        this.suppressClipping = suppressClipping;
    }

    @Override
    public Transform getTransform() {
        return transform;
    }

    @Override
    public void setTransform(Transform transform) {
        this.transform = transform;
    }

    public boolean mouseHoversOver() {
        return mouseHoversOver;
    }

    protected void setMouseHoversOver(boolean mouseHoversOver) {
        this.mouseHoversOver = mouseHoversOver;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
    }
}
