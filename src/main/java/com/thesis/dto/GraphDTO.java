package com.thesis.dto;

import java.util.List;

/**
 * Created by lap08 on 8/11/2017.
 */
public class GraphDTO {

    List<NodeGraph> nodes;
    List<LinkGraph> links;
    List<TypeNodeGraph> types;

    public GraphDTO(List<NodeGraph> nodes, List<LinkGraph> links, List<TypeNodeGraph> types) {
        this.nodes = nodes;
        this.links = links;
        this.types = types;
    }

    public List<TypeNodeGraph> getTypes() {
        return types;
    }

    public GraphDTO setTypes(List<TypeNodeGraph> types) {
        this.types = types;
        return this;
    }

    public List<NodeGraph> getNodes() {
        return nodes;
    }

    public GraphDTO setNodes(List<NodeGraph> nodes) {
        this.nodes = nodes;
        return this;
    }

    public List<LinkGraph> getLinks() {
        return links;
    }

    public GraphDTO setLinks(List<LinkGraph> links) {
        this.links = links;
        return this;
    }

    public class NodeGraph {
        int id;
        int type;
        String name;

        public NodeGraph(int id, int type, String name) {
            this.id = id;
            this.type = type;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public NodeGraph setId(int id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public NodeGraph setName(String name) {
            this.name = name;
            return this;
        }

        public int getType() {
            return type;
        }

        public NodeGraph setType(int type) {
            this.type = type;
            return this;
        }
    }

    public class TypeNodeGraph {
        String name;
        int id;

        public TypeNodeGraph(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public TypeNodeGraph setName(String name) {
            this.name = name;
            return this;
        }

        public int getId() {
            return id;
        }

        public TypeNodeGraph setId(int id) {
            this.id = id;
            return this;
        }
    }

    public class LinkGraph {
        int source;
        int target;
        int value;

        public LinkGraph(int source, int target, int value) {
            this.source = source;
            this.target = target;
            this.value = value;
        }

        public int getSource() {
            return source;
        }

        public LinkGraph setSource(int source) {
            this.source = source;
            return this;
        }

        public int getTarget() {
            return target;
        }

        public LinkGraph setTarget(int target) {
            this.target = target;
            return this;
        }

        public int getValue() {
            return value;
        }

        public LinkGraph setValue(int value) {
            this.value = value;
            return this;
        }
    }

}


