/*
 * Copyright (c) by Malte Dostal
 * Germany, 8.2018
 * All rights reserved
 */

package de.edgelord.saltyengine.components;

import de.edgelord.saltyengine.core.Component;
import de.edgelord.saltyengine.core.event.CollisionEvent;
import de.edgelord.saltyengine.core.stereotypes.ComponentParent;
import de.edgelord.saltyengine.gameobject.Components;
import de.edgelord.saltyengine.graphics.SaltyGraphics;

import java.awt.*;

public class DrawPositionComponent extends Component {

    public DrawPositionComponent(ComponentParent parent, String name) {
        super(parent, name, Components.TECHNICAL_DRAW_COMPONENT);
    }

    @Override
    public void onFixedTick() {

    }

    @Override
    public void draw(SaltyGraphics saltyGraphics) {

        saltyGraphics.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
        saltyGraphics.setColor(Color.BLACK);

        saltyGraphics.drawText(String.valueOf(getParent().getX()), getParent().getX(), getParent().getY() - 5);

        String yPosition = String.valueOf(getParent().getY());

        saltyGraphics.drawText(yPosition, getParent().getX() - (yPosition.length() * 7), getParent().getY() + 25);
    }

    @Override
    public void onCollision(CollisionEvent e) {

    }
}