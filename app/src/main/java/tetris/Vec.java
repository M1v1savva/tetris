package tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.*;
import java.lang.*;

public class Vec {

	public double[] v;
	public int length = 0;

	public Vec() {

	}

	public Vec(int len) {
		v = new double[len];
		length = len;
	}

	public Vec(double[] _v) {
		v = _v;
		length = v.length;
	}

	public static Vec add(Vec l, Vec r) {
		Vec res = new Vec(l.length);	
		for (int i = 0; i < l.length; i++)
			res.v[i] = l.v[i] + r.v[i];
		return res;
	}

	public static Vec substract(Vec l, Vec r) {
		Vec res = new Vec(l.length);
		for (int i = 0; i < l.length; i++)
			res.v[i] = l.v[i] - r.v[i];
		return res;
	}

	public static double multiply(Vec l, Vec r) {
		double res = 0;
		for (int i = 0; i < l.length; i++)
			res += l.v[i] * r.v[i];
		return res;
	}

	public static Vec multiply(Vec l, double r) {
		Vec res = new Vec(l.length);
		for (int i = 0; i < l.length; i++) 
			res.v[i] = l.v[i] * r;
		return res;
	}

	public static Vec divide(Vec l, double r) {
		Vec res = new Vec(l.length);
		for (int i = 0; i < l.length; i++) 
			res.v[i] = l.v[i] / r;
		return res;
	}

	public double size() {
		double res = 0;
		for (int i = 0; i < length; i++) 
			res += v[i] * v[i];
		return Math.sqrt(res);
	}

	public void normalize() {
		double len = size();
		for (int i = 0; i < length; i++) 
			v[i] /= len;
	}

	public boolean equals(Object otherObject) {
		if (otherObject == null)
			return false;
		if (otherObject.getClass() != getClass())
			return false;
		Vec r = (Vec)otherObject;
		return (length == r.length && v == r.v);
	}
}