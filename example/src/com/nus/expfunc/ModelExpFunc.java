package com.nus.expfunc;

/**
 * Created by duy on 29/1/15.
 */

import com.nus.LmScalarModel;

/**
 * Model: f(x) = e^(a * x) + b * x
 */
public class ModelExpFunc implements LmScalarModel {
  private double[] x;
  private double[] y;

  public ModelExpFunc(double x[], double y[]) {
    this.x = x;
    this.y = y;
  }

  @Override
  public double[] getMeasuredData() {
    return y;
  }

  @Override
  public double eval(int dataIdx, double[] ab) {
    return Math.exp(ab[0] * x[dataIdx]) + ab[1] * x[dataIdx];
  }

  @Override
  public double[] jacobian(int dataIdx, double[] ab) {
    double[] jVector = new double[2];
    jVector[0] = x[dataIdx] * Math.exp(ab[0] * x[dataIdx]);
    jVector[1] = x[dataIdx];
    return jVector;
  }

  @Override
  public double[][] hessian(int dataIdx, double[] ab) {
    double[][] mat = new double[2][2];

    mat[0][0] = x[dataIdx] * x[dataIdx] * Math.exp(ab[0] * x[dataIdx]);
    mat[1][1] = 0.0;
    mat[0][1] = mat[1][0] = 0.0;

    return mat;
  }
}
