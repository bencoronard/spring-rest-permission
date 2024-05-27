import ReactDOM from "react-dom";

export function PortalDemo() {
  const portalRoot = document.getElementById("portal-root");
  if (portalRoot) {
    return ReactDOM.createPortal(<h1>Portal</h1>, portalRoot);
  } else {
    return null;
  }
}
