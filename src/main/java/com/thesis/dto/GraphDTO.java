package com.thesis.dto;

import java.util.List;

/**
 * Created by lap08 on 8/11/2017.
 */
public class GraphDTO {

    List<NodeGraph> nodes;
    List<LinkGraph> links;

    public GraphDTO(List<NodeGraph> nodes, List<LinkGraph> links) {
        this.nodes = nodes;
        this.links = links;
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
        String id;
        int group;
        String type;

        public NodeGraph(String id, int group, String type) {
            this.id = id;
            this.group = group;
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public NodeGraph setId(String id) {
            this.id = id;
            return this;
        }

        public int getGroup() {
            return group;
        }

        public NodeGraph setGroup(int group) {
            this.group = group;
            return this;
        }

        public String getType() {
            return type;
        }

        public NodeGraph setType(String type) {
            this.type = type;
            return this;
        }
    }

    public class LinkGraph {
        String source;
        String target;
        int value;

        public LinkGraph(String source, String target, int value) {
            this.source = source;
            this.target = target;
            this.value = value;
        }

        public String getSource() {
            return source;
        }

        public LinkGraph setSource(String source) {
            this.source = source;
            return this;
        }

        public String getTarget() {
            return target;
        }

        public LinkGraph setTarget(String target) {
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


