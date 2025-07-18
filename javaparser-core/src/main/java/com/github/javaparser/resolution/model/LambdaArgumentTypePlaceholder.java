/*
 * Copyright (C) 2015-2016 Federico Tomassetti
 * Copyright (C) 2017-2024 The JavaParser Team.
 *
 * This file is part of JavaParser.
 *
 * JavaParser can be used either under the terms of
 * a) the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * b) the terms of the Apache License
 *
 * You should have received a copy of both licenses in LICENCE.LGPL and
 * LICENCE.APACHE. Please refer to those files for details.
 *
 * JavaParser is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 */
package com.github.javaparser.resolution.model;

import com.github.javaparser.resolution.declarations.ResolvedMethodLikeDeclaration;
import com.github.javaparser.resolution.types.ResolvedType;
import java.util.Optional;

/**
 * Placeholder used to represent a lambda argument type while it is being
 * calculated.
 *
 * @author Federico Tomassetti
 */
public class LambdaArgumentTypePlaceholder implements ResolvedType {

    private int pos;

    private final Optional<Integer> parameterCount;

    private final Optional<Boolean> bodyBlockHasExplicitNonVoidReturn;

    private SymbolReference<? extends ResolvedMethodLikeDeclaration> method;

    public LambdaArgumentTypePlaceholder(int pos) {
        this.pos = pos;
        this.parameterCount = Optional.empty();
        this.bodyBlockHasExplicitNonVoidReturn = Optional.empty();
    }

    public LambdaArgumentTypePlaceholder(
            int pos, int parameterCount, Optional<Boolean> bodyBlockHasExplicitNonVoidReturn) {
        this.pos = pos;
        this.parameterCount = Optional.of(parameterCount);
        this.bodyBlockHasExplicitNonVoidReturn = bodyBlockHasExplicitNonVoidReturn;
    }

    public Optional<Integer> getParameterCount() {
        return parameterCount;
    }

    public Optional<Boolean> bodyBlockHasExplicitNonVoidReturn() {
        return bodyBlockHasExplicitNonVoidReturn;
    }

    @Override
    public boolean isArray() {
        return false;
    }

    @Override
    public boolean isReferenceType() {
        return false;
    }

    @Override
    public String describe() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isTypeVariable() {
        return false;
    }

    public void setMethod(SymbolReference<? extends ResolvedMethodLikeDeclaration> method) {
        this.method = method;
    }

    @Override
    public boolean isAssignableBy(ResolvedType other) {
        throw new UnsupportedOperationException();
    }
}
