# Navigation elements

## Inventory

| Fragment Class                                  | Title            | Layout / XML resource     | Top-level? |         Superclass         |
|:------------------------------------------------|:-----------------|:--------------------------|:----------:|:--------------------------:|
| `PreLoginFragment`*                             | (none)           | (none)                    |     No     |                            |
| `LoginFragment`*                                | Sign In          | fragment_login            |     No     |                            |
| `GameFragment`                                  | Play             | fragment_game             |    Yes     |                            |
| `GameSummaryFragment(a DialogFragment) `        | Game Over        | (none)                    |     No     |       DialogFragment                     |
| `HistoryFragment `                              | History          | (none)                    |    Yes     |                            |
| `BadgesFragment`                                | Badges           | (none)                    |    Yes     |                            |
| `ProfileFragment`                               | Profile          | fragment_profile          |     No     |                            |
| `SettingsFragment (a PreferenceFragmentCompat)` | Settings         | XML                   |    Yes     | `PreferenceFragmentCompat` |
| `WheelOfChangeFragment (a DialogFragment)`      | Wheel of Change  | fragment_wheel_of_change  |     No     |                            |
| `PicturePackagesFragment`                       | Picture Packages | fragment_picture_packages | Yes or No  |                            |

## Organization

- All fragment classes are either already present in the
  `edu.cnm.deepdive.handsolitaire.app.controller` package, or should be created in that package.
- All referenced layouts are either existing layout resources, existing XML resources, or should be
  created, using a root element of `ConstraintLayout` for Fragment subclasses, and an XML resource
  with a PreferenceScreen root element for PreferenceFragment subclasses.

## Widget

- Top-level navigation will use a `BottomNavigationView` with a `FragmentContainerView`. (BottomNav)

- The menu resource used by the navigation view should be named `main_options`.

## Host

- Navigation controls and controllers should be hosted inside an activity named `MainActivity` using
  a layout resource named `activity_main`.

- Activity classes should reside in the `edu.cnm.deepdive.handsolitaire.app.controller` package.

## Navigation view and fragment synchronization

- Navigation action and state changes will use the Jetpack navigation component, with an
  `AppBarConfiguration` tied to a `NavController`, and the `NavController` tied to a
  `NavigationView`. (non-tabbed)

- Navigation action and display changes will use th `ViewPager2` component, driven by a
  `PrimaryTabRow` a `FragmentStateAdapter` subclass.

## General

- View binding will be used in all Fragment subclasses (other than `PreferenceFragmentCompat`.
  subclasses).

- All view binding instance reference properties should be named `binding`. In Kotlin fragments, this should be a `lateinit var` property; in Kotlin activities, this should be declared as a `val`property, initialized `by lazy`.
