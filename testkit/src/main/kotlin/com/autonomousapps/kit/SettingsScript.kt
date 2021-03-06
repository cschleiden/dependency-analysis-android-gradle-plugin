package com.autonomousapps.kit

class SettingsScript(
  val pluginManagement: PluginManagement = PluginManagement.DEFAULT,
  val rootProjectName: String = "the-project",
  val subprojects: Set<String> = emptySet()
) {

  override fun toString(): String {
    return pluginManagement.block + '\n' +
      "rootProject.name = '$rootProjectName'\n" +
      subprojects.joinToString("\n") { "include ':$it'" }
  }
}
