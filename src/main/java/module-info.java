module waterworld {
    requires hanyaeger;

    exports com.github.hanyaeger.tutorial;

    opens audio;
    opens backgrounds;
    opens sprites;
    exports com.github.hanyaeger.tutorial.scenes;
    exports com.github.hanyaeger.tutorial.entities.map;
}
