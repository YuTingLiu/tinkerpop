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

package org.apache.tinkerpop.gremlin.process.traversal.step.map

import org.apache.tinkerpop.gremlin.process.traversal.Traversal
import org.apache.tinkerpop.gremlin.process.traversal.util.ScriptTraversal
import org.apache.tinkerpop.gremlin.structure.Vertex

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public abstract class GroovyPageRankTest {

    public static class Traversals extends PageRankTest {

        @Override
        public Traversal<Vertex, Vertex> get_g_V_pageRank() {
            new ScriptTraversal<>(g, "gremlin-groovy", "g.V.pageRank")
        }

        @Override
        public Traversal<Vertex, Map<String, List<Object>>> get_g_V_pageRank_byXoutEXknowsXX_byXfriendRankX_valueMapXname_friendRankX() {
            new ScriptTraversal<>(g, "gremlin-groovy", "g.V.pageRank.by(outE('knows')).by('friendRank').valueMap('name','friendRank')")
        }

        @Override
        public Traversal<Vertex, String> get_g_V_pageRank_order_byXpageRank_decrX_name() {
            new ScriptTraversal<>(g, "gremlin-groovy", "g.V.pageRank.order.by(PageRankVertexProgram.PAGE_RANK, decr).name")
        }

        @Override
        public Traversal<Vertex, String> get_g_V_pageRank_order_byXpageRank_decrX_name_limitX2X() {
            new ScriptTraversal<>(g, "gremlin-groovy", "g.V.pageRank.order.by(PageRankVertexProgram.PAGE_RANK, decr).name.limit(2)")
        }

        @Override
        public Traversal<Vertex, Map<String, List<Object>>> get_g_V_hasLabelXpersonX_pageRank_byXpageRankX_order_byXpageRankX_valueMapXname_pageRankX() {
            new ScriptTraversal<>(g, "gremlin-groovy", "g.V.hasLabel('person').pageRank.by('pageRank').order.by('pageRank').valueMap('name', 'pageRank')")
        }
    }
}
