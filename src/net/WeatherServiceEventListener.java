/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net;

/**
 *
 * @author hansolo
 */
public interface WeatherServiceEventListener extends java.util.EventListener
{
    public void weatherServiceEventPerformed (WeatherServiceEvent event);
}
