/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/**
 * Copyright DataStax, Inc.
 *
 * Please see the included license file for details.
 */
package org.apache.tinkerpop.gremlin.spark.structure.io.gryo.kryoshim.unshaded;

import com.esotericsoftware.kryo.Kryo;
import org.apache.tinkerpop.gremlin.structure.io.gryo.kryoshim.KryoShim;

public class UnshadedKryoAdapter implements KryoShim<UnshadedInputAdapter, UnshadedOutputAdapter>
{
    private final Kryo unshadedKryo;

    public UnshadedKryoAdapter(Kryo unshadedKryo)
    {
        this.unshadedKryo = unshadedKryo;
    }

    @Override
    public <T> T readObject(UnshadedInputAdapter input, Class<T> type)
    {
        return unshadedKryo.readObject(input.getUnshadedInput(), type);
    }

    @Override
    public Object readClassAndObject(UnshadedInputAdapter input)
    {
        return unshadedKryo.readClassAndObject(input.getUnshadedInput());
    }

    @Override
    public void writeObject(UnshadedOutputAdapter output, Object object)
    {
        unshadedKryo.writeObject(output.getUnshadedOutput(), object);
    }

    @Override
    public void writeClassAndObject(UnshadedOutputAdapter output, Object object)
    {
        unshadedKryo.writeClassAndObject(output.getUnshadedOutput(), object);
    }

    @Override
    public <T> T readObjectOrNull(UnshadedInputAdapter input, Class<T> type)
    {
        return unshadedKryo.readObjectOrNull(input.getUnshadedInput(), type);
    }

    @Override
    public void writeObjectOrNull(UnshadedOutputAdapter output, Object object, Class type)
    {
        unshadedKryo.writeObjectOrNull(output.getUnshadedOutput(), object, type);
    }
}
